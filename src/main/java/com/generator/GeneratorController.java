package com.generator;

import javafx.event.Event;

public class GeneratorController {
    private GeneratorModel model;			/* declara obiect */
    private GeneratorView view;			/* declara obiect */

    public GeneratorController(GeneratorModel model, GeneratorView view) {
        this.model = model;			/* initializeaza obiect */
        this.view = view;			/* initializeaza obiect */
        inregistreazaMetode();		/* inregistreaza metodele de tratare */
    }

    private void inregistreazaMetode() {
        view.butGenereaza().setOnAction(this::actualizeazaInterfata);
        view.cdsMinuscule().setOnAction(this::includeMinusculele);
        view.cdsMajuscule().setOnAction(this::includeMajusculele);
        view.cdsCifre().setOnAction(this::includeCifrele);
        view.cdsSimboluri().setOnAction(this::includeSimbolurile);
        view.glsLungime().setOnMouseClicked(this::seteazaLungimea);
        view.glsLungime().setOnDragDone(this::seteazaLungimea);
        view.cdtParola().setOnMouseClicked(this::selecteazaSiCopiaza);
        view.getBtnCopy().setOnMouseClicked(this::copyToClipboard);
    }

    private void actualizeazaInterfata(Event event) {
        String parola = model.nextPassword();	/* obtine parola */
        view.cdtParola().setText(parola);		/* actualizeaza intervata */
    }

    private void includeMinusculele(Event event) {
        boolean minusculeleIncluse = view.suntIncluseMinusculele();
        model.setLowerCaseLetters(minusculeleIncluse);
    }

    private void includeMajusculele(Event event) {
        boolean majusculeleIncluse = view.suntIncluseMajusculele();
        model.setUpperCaseLetters(majusculeleIncluse);
    }

    private void includeCifrele(Event event) {
        boolean cifreleIncluse = view.suntIncluseCifrele();
        model.setDigits(cifreleIncluse);
    }

    private void includeSimbolurile(Event event) {
        boolean simbolurileIncluse = view.suntIncluseSimbolurile();
        model.setSymbols(simbolurileIncluse);
    }

    private void seteazaLungimea(Event event) {
        int lungime = (int)view.glsLungime().getValue();
        model.setLength(lungime);
    }

    private void selecteazaSiCopiaza(Event event) {
        view.cdtParola().selectAll();
        view.cdtParola().copy();
    }

    private void copyToClipboard(Event event) {
        view.cdtParola().copy();
    }
}
