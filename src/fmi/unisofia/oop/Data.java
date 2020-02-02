package fmi.unisofia.oop;

public class Data {
    private int someField;
    private String otherField;

    public Data(int someField, String otherField) {
        this.someField = someField;
        this.otherField = otherField;
    }

    public int getSomeField() {
        return someField;
    }

    public String getOtherField() {
        return otherField;
    }

    private void setSomeField(int someField) {
        this.someField = someField;
    }

    private void setOtherField(String otherField) {
        this.otherField = otherField;
    }
}
