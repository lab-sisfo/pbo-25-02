// package Tuprak 3;

public class ShadowPower {
    private int darkness;
    private double shadowAura;
    
    public ShadowPower(int darkness, double shadowAura){
        this.darkness = darkness;
        this.shadowAura = shadowAura;
    }
    public int getPower(){
        return darkness + (int) shadowAura;
    
}
}
