package com.generator;

public class GeneratorModel {
    /** Lower case letters that can be selected in the generated password */
    private static final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    /** Upper case letters that can be selected in the generated password*/
    private static final String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /** Digits that can be included in the generated password */
    private static final String DIGITS = "0123456789";

    /** Symbols that can be included in the generated password */
    private static final String SYMBOLS = "!?@#$%^&*(){}[]<>~+=-_\\/|;:,";

    /** Default password length */
    private static final int DEFAULT_LENGTH = 10;

    /** Variabila booleana, indica incluziunea
     * literelor mari in multimea de caractere */
    private boolean hasUpperCaseLetters = false;

    /** Variabila booleana, indica incluziunea
     * literelor mici in multimea de caractere */
    private boolean hasLowerCaseLetters = true;

    /** Variabila booleana, indica incluziunea
     * cifrelor in multimea de caractere */
    private boolean hasDigits = true;

    /** Variabila booleana, indica incluziunea
     * simbolurile in multimea de caractere */
    private boolean hasSymbols = false;

    /** Variabila intreg, indica length parolei */
    private int length = DEFAULT_LENGTH;

    /** Obiect de tip StringBuilder, reprezinta multimea
     * de caractere de unde se vor alege caracterele parolei */
    private StringBuilder charBuilder = new StringBuilder();

    /** No args constructor */
    public GeneratorModel() {
        updateCharacterSet();
    }

    /** Metoda publica, are ca scop generarea parolei si
     * intoarcerea acesteia ca un obiect de tip String */
    public String nextPassword() {
        StringBuilder password = new StringBuilder(length);

        if (charBuilder.length() > 0) {
            for (int i = 0; i < length; i++) {
                int randIndex = (int)(Math.random() * charBuilder.length());
                password.append(charBuilder.charAt(randIndex));
            }
        }

        return password.toString();
    }

    /** Metoda publica, seteaza length parolei */
    public void setLength(int length) {
        this.length = length;
    }

    /** Metoda publica, are ca scop setarea variabilei
     * hasUpperCaseLetters, si actualizarea multimii de
     * caractere charBuilder */
    public void setUpperCaseLetters(boolean hasUpperCaseLetters) {
        this.hasUpperCaseLetters = hasUpperCaseLetters;
        updateCharacterSet();
    }

    /** Metoda publica, are ca scop setarea variabilei
     * hasLowerCaseLetters, si actualizarea multimii de
     * caractere charBuilder */
    public void setLowerCaseLetters(boolean hasLowerCaseLetters) {
        this.hasLowerCaseLetters = hasLowerCaseLetters;
        updateCharacterSet();
    }

    /** Metoda publica, are ca scop setarea variabilei
     * hasDigits, si actualizarea multimii de
     * caractere charBuilder */
    public void setDigits(boolean hasDigits) {
        this.hasDigits = hasDigits;
        updateCharacterSet();
    }


    /** Metoda publica, are ca scop setarea variabilei
     * includeSymbols, si actualizarea multimii de
     * caractere charBuilder */
    public void setSymbols(boolean hasSymbols) {
        this.hasSymbols = hasSymbols;
        updateCharacterSet();
    }


    /** Metoda privata, care este apelata in interiorul
     *  clasei pentru actualizarea multimii de caractere. */
    private void updateCharacterSet() {
        charBuilder.delete(0, charBuilder.length());

        if (hasLowerCaseLetters)
            charBuilder.append(LOWER_CASE_LETTERS);

        if (hasUpperCaseLetters)
            charBuilder.append(UPPER_CASE_LETTERS);

        if (hasDigits)
            charBuilder.append(DIGITS);

        if (hasSymbols)
            charBuilder.append(SYMBOLS);
    }
}
