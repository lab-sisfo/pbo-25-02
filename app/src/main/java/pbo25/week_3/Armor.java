public class Armor {
    private String body;
    private String head;
    
    public Armor(String body, String head){
        this.body = body;
        this.head = head;
    }

    public int getDefense(int random){
        return (body.length() + head.length() + random) / 2;
    }
}
