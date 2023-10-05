package com.patricksoftwarestar.star.view.registration;

import com.vaadin.flow.component.button.Button;
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

    protected RegistrationView(String nameView) {
        this.nameView = nameView;
        this.registerListGR = new Grid<>();
        this.insertRegisterBt = new Button("Insert "+nameView);
        this.removeRegisterBt = new Button("Remove "+nameView);
        this.editRegisterBt = new Button("Edit "+nameView);
        this.horizontalLayout = new HorizontalLayout();
        this.verticalLayout = new VerticalLayout();
        this.horizontalLayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
    }


    protected void initListeners() {

    }

    protected void initGrid() {

    }

    protected void addComponets() {
        this.horizontalLayout.add(insertRegisterBt, removeRegisterBt, editRegisterBt);
        add(new H1(nameView), horizontalLayout, verticalLayout, registerListGR);
    }
}
