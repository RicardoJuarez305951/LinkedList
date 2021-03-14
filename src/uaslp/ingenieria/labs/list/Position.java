package uaslp.ingenieria.labs.list;

public enum Position {
    BEFORE("Este es antes"),
    AFTER("Este es después");

    private String message;

    Position(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return message;
    }
}
