package com.patricksoftwarestar.front;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


public class RegistrationView<T> extends VerticalLayout {

    protected HorizontalLayout horizontalLayout;
    protected Grid<T> registerListGR;
    protected Button insertRegisterBt;
    protected Button removeRegisterBt;
    protected Button editRegisterBt;
    protected VerticalLayout verticalLayout;
    protected String nameView;
    protected FormLayout textFieldsFm;

    protected FormLayout buttonsFm;

    protected RegistrationView(String nameView) {
        this.nameView = "CRUD " + nameView;
        this.registerListGR = new Grid<>();
        this.insertRegisterBt = new Button("Insert "+nameView);
        this.removeRegisterBt = new Button("Clear List "+nameView);
        this.editRegisterBt = new Button("Edit "+nameView);
        this.horizontalLayout = new HorizontalLayout();
        this.verticalLayout = new VerticalLayout();
        this.horizontalLayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        this.textFieldsFm = new FormLayout();
        this.buttonsFm = new FormLayout();
    }


    protected void initListeners() {

    }

    protected void initGrid() {

    }

    protected void addComponents() {
        this.horizontalLayout.add();
        add(new H1(nameView), horizontalLayout, verticalLayout, registerListGR);
    }

    protected void addFieldsInForm(Component... components){
        textFieldsFm.add(components);
        textFieldsFm.add(new VerticalLayout(insertRegisterBt, removeRegisterBt, editRegisterBt));
        textFieldsFm.setResponsiveSteps(new FormLayout.ResponsiveStep("100px", 2));
        //buttonsFm.setResponsiveSteps(new FormLayout.ResponsiveStep("50px", 3));
    }


}
