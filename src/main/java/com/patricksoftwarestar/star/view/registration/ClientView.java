package com.patricksoftwarestar.star.view.registration;

import static com.vaadin.componentfactory.addons.inputmask.InputMaskOption.option;

import com.patricksoftwarestar.star.dto.ClientDTO;
import com.patricksoftwarestar.star.model.Client;
import com.patricksoftwarestar.star.service.registration.ClientService;
import com.vaadin.componentfactory.addons.inputmask.InputMask;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Route("/ClientView")
public class ClientView extends RegistrationView<Client> {

    ClientService clientService;
    TextField clientNameTF;
    TextField clientCPFTF;

    public ClientView(ClientService clientService) {
        super("Client");
        this.clientService = clientService;
        this.clientNameTF = new TextField("Name");
        this.clientCPFTF = new TextField("CPF");


        horizontalLayout.add(clientNameTF, clientCPFTF);
        initGrid();
        initListeners();
        iniMask();
        addComponets();
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
        List<Client> clientList = clientService.getAllClients();

        registerListGR.setItems(clientList);
    }

    private void removeRegister(Client client) {
        if(!Objects.isNull(client)) {
            clientService.deleteById(client.getId());
            var newClientList = clientService.getAllClients();
            registerListGR.setItems(newClientList);
            registerListGR.getDataProvider().refreshAll();
        }
    }


    @Override
    protected void initListeners() {
        insertRegisterBt.addClickListener(click -> {
            var client = clientService.save(new ClientDTO(clientNameTF.getValue(), clientCPFTF.getValue()));
            if (Objects.nonNull(client)) {
                var newClientList = clientService.getAllClients();
                registerListGR.setItems(newClientList);
                registerListGR.getDataProvider().refreshAll();
            }
        });

        removeRegisterBt.addClickListener(click -> {
            clientService.deleteAll();
            registerListGR.setItems(new ArrayList<>());
            registerListGR.getDataProvider().refreshAll();
        });

        //registerListGR.asSingleSelect().addValueChangeListener(event -> updateFields(event.getValue()));
        registerListGR.addSelectionListener(event -> updateFields(event.getFirstSelectedItem().orElse(null)));
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
