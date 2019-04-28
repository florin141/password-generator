package com.generator;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GeneratorView extends VBox {
    /* CONSTANTE */
    public static final Insets MARGINE = new Insets(0, 50, 0, 50);
    public static final int DIMSIUNE_TEXT = 36;
    public static final Font FONT_CASETA_TEXT =
            Font.font(null, FontWeight.BOLD, DIMSIUNE_TEXT);

    /* COMPONENTELE INTERFETEI */
    private final Label etcParola = new Label("STRONG PASSWORD GENERATOR");
    private final TextField cdtParola = new TextField();
    private final Slider glsLungime = new Slider(5, 30, 10);
    private final CheckBox cdsMinuscule = new CheckBox("Lower Case Letters");
    private final CheckBox cdsMajuscule = new CheckBox("Upper Case Letters");
    private final CheckBox cdsCifre = new CheckBox("Digits");
    private final CheckBox cdsSimboluri = new CheckBox("Symbols");
    private final Button butGenereaza = new Button("Update");

    private final Button btnCopy = new Button("Copy");

    public GeneratorView() { init(); }

    private void init() {
        etcParola.setFont(Font.font(DIMSIUNE_TEXT)); 	/* seteaza font */

        cdtParola.setFont(FONT_CASETA_TEXT);	/* seteaza font */
        cdtParola.setAlignment(Pos.CENTER);		/* seteaza alinierea */
        cdtParola.setPrefWidth(698);		/* seteaza latimea preferata */
        cdtParola.setMinWidth(430);			/* seteaza latimea minima */
        cdtParola.setMaxWidth(960);			/* seteaza latimea maxima */

        butGenereaza.setDefaultButton(true); /* seteaza ca buton implicit */
        butGenereaza.setPrefSize(200, 25);	/* seteaza dimens preferata */
        butGenereaza.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
        butGenereaza.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);

        glsLungime.setMajorTickUnit(1);	/* seteaza distanta intre gradatii */
        glsLungime.setMinorTickCount(0); 	/* nr de linii intre gradatii */
        glsLungime.setShowTickLabels(true); 	/* afiseaza gradatiile */
        glsLungime.setSnapToTicks(true); /* se opreste fix la o gradatie */
        glsLungime.setPrefWidth(698);	/* seteaza latimea preferata */
        glsLungime.setMinWidth(430);	/* seteaza latimea minima */
        glsLungime.setMaxWidth(960);	/* seteaza latimea maxima */

        cdsMinuscule.setSelected(true);	  /* selecteaza caseta de selecare */
        cdsCifre.setSelected(true);		/* selecteaza caseta de selecare */

        HBox contCds = new HBox(20);	/* container casete de selectare */
        contCds.setAlignment(Pos.CENTER);	/* seteaza alinierea */
        contCds.getChildren().addAll(
                cdsMinuscule, cdsMajuscule,
                cdsCifre, cdsSimboluri);		/* adauga noduri */

        VBox.setMargin(cdtParola, MARGINE);		/* seteaza margine */
        VBox.setMargin(glsLungime, MARGINE);	/* seteaza margine */

        this.setSpacing(20);					/* seteaza spatiul */
        this.setAlignment(Pos.CENTER);			/* seteaza alinierea */
        this.getChildren().addAll(etcParola, cdtParola,
                glsLungime, contCds, butGenereaza);		/* adauga noduri */
    }

    public boolean suntIncluseMajusculele() {
        return cdsMajuscule.isSelected();
    }

    public boolean suntIncluseMinusculele() {
        return cdsMinuscule.isSelected();
    }

    public boolean suntIncluseCifrele() {
        return cdsCifre.isSelected();
    }

    public boolean suntIncluseSimbolurile() {
        return cdsSimboluri.isSelected();
    }

    public Slider glsLungime() {
        return glsLungime;
    }

    public CheckBox cdsSimboluri() {
        return cdsSimboluri;
    }

    public CheckBox cdsCifre() {
        return cdsCifre;
    }

    public CheckBox cdsMajuscule() {
        return cdsMajuscule;
    }

    public CheckBox cdsMinuscule() {
        return cdsMinuscule;
    }

    public Button butGenereaza() {
        return butGenereaza;
    }

    public TextField cdtParola() {
        return cdtParola;
    }

    public Button getBtnCopy() {
        return btnCopy;
    }
}
