package com.patricksoftwarestar.front;

import com.patricksoftwarestar.core.model.Client;
import com.patricksoftwarestar.core.model.Product;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Route("/ProductView")
public class ProductView extends RegistrationView<Product> {

    TextField productNameTF;
    TextField productPrice;

    TextField findBar;

    public ProductView() {
        super("Product");

        this.productNameTF = new TextField("Name");
        this.productPrice = new TextField("Price");
        this.findBar = new TextField("Search");

        addFieldsInForm(new VerticalLayout(this.productNameTF, this.productPrice,this.findBar));
        horizontalLayout.add(textFieldsFm);
        initGrid();
        initListeners();
        iniMask();
        addComponents();
    }

    @Override
    protected void initGrid() {
        registerListGR.addColumn(Product::getName).setHeader("Nome");
        registerListGR.addColumn(Product::getPrice).setHeader("Price");
        registerListGR.addColumn(
                new ComponentRenderer<>(Button::new, (button, product) -> {
                    button. addThemeVariants(ButtonVariant.LUMO_ICON,
                            ButtonVariant.LUMO_ERROR,
                            ButtonVariant.LUMO_TERTIARY);
                    button.addClickListener(e -> this.removeRegister(product));
                    button.setIcon(new Icon(VaadinIcon.TRASH));
                })).setHeader("Delete");
        List<Product> clientList = new ArrayList<>();

        registerListGR.setItems(clientList);
    }

    private void removeRegister(Product product) {
        if(!Objects.isNull(product)) {
            List<Client> newClientList = new ArrayList<>();;
            registerListGR.getDataProvider().refreshAll();
        }
    }


    @Override
    protected void initListeners() {
        insertRegisterBt.addClickListener(click -> {
            var product = Product.builder().build();
            if (Objects.nonNull(product)) {
                registerListGR.setItems();
                registerListGR.getDataProvider().refreshAll();
            }
        });

        removeRegisterBt.addClickListener(click -> {
            registerListGR.setItems(new ArrayList<>());
            registerListGR.getDataProvider().refreshAll();
        });

        registerListGR.addSelectionListener(event -> updateFields(event.getFirstSelectedItem().orElse(null)));

        findBar.addKeyUpListener(Key.ENTER, value ->{
            registerListGR.getDataProvider().refreshAll();
        });
    }

    protected void iniMask() {
        //new InputMask("R$ 000.000,00").extend(productPrice);
    }

    protected void updateFields(Product value) {
        if(!Objects.isNull(value)) {
            productNameTF.setValue(value.getName());
            productPrice.setValue(value.getPrice().toString());
            System.out.println(value.getId());
        }
    }
}
