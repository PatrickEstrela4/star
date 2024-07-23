package com.patricksoftwarestar.front;

import com.patricksoftwarestar.core.model.Client;
import com.vaadin.componentfactory.addons.inputmask.InputMask;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Route("/ClientView")
public class ClientView extends RegistrationView<Client> {

    TextField clientNameTF;
    TextField clientCPFTF;

    TextField findBar;

    public ClientView() {
        super("Client");

        this.clientNameTF = new TextField("Name");
        this.clientCPFTF = new TextField("CPF");
        this.findBar = new TextField("Search");

        addFieldsInForm(new VerticalLayout(this.clientNameTF, this.clientCPFTF,this.findBar));
        horizontalLayout.add(textFieldsFm);
        initGrid();
        initListeners();
        iniMask();
        addComponents();
    }

    @Override
    protected void initGrid() {
        registerListGR.addColumn(Client::getName).setHeader("Nome");
        registerListGR.addColumn(Client::getCpf).setHeader("CPF");
        registerListGR.addColumn(
                new ComponentRenderer<>(Button::new, (button, client) -> {
                    button. addThemeVariants(ButtonVariant.LUMO_ICON,
                            ButtonVariant.LUMO_ERROR,
                            ButtonVariant.LUMO_TERTIARY);
                    button.addClickListener(e -> this.removeRegister(client));
                    button.setIcon(new Icon(VaadinIcon.TRASH));
                })).setHeader("Delete");
        List<Client> clientList = new ArrayList<>();

        registerListGR.setItems(clientList);
    }

    private void removeRegister(Client client) {
        if(!Objects.isNull(client)) {
            List<Client> newClientList = new ArrayList<>();
            registerListGR.setItems(newClientList);
            registerListGR.getDataProvider().refreshAll();
        }
    }


    @Override
    protected void initListeners() {
        insertRegisterBt.addClickListener(click -> {
            List<Client> client = new ArrayList<>();
            if (Objects.nonNull(client)) {
                registerListGR.setItems(client);
                registerListGR.getDataProvider().refreshAll();
            }
        });

        removeRegisterBt.addClickListener(click -> {
            registerListGR.setItems(new ArrayList<>());
            registerListGR.getDataProvider().refreshAll();
        });

        registerListGR.addSelectionListener(event -> updateFields(event.getFirstSelectedItem().orElse(null)));

        findBar.addKeyUpListener(Key.ENTER, value ->{
            List<Client> newClientList = new ArrayList<>();
            registerListGR.setItems(newClientList);
            registerListGR.getDataProvider().refreshAll();
        });
    }

    protected void iniMask() {
        new InputMask("000.000.000-00").extend(clientCPFTF);
    }

    protected void updateFields(Client value) {
        if(!Objects.isNull(value)) {
            clientNameTF.setValue(value.getName());
            clientCPFTF.setValue(value.getCpf());
            System.out.println(value.getId());
        }
    }
}
