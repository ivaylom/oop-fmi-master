package fmi.unisofia.oop;

public class Data2 {
    private int someField;
    private String otherField;

    private Data2(int someField, String otherField) {
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

    @Override
    public String toString() {
        return "Data2{" +
                "someField=" + someField +
                ", otherField='" + otherField + '\'' +
                '}';
    }

    public static Data2 createData(int someField) {
        return new Data2(someField, String.valueOf(someField));
    }
}
