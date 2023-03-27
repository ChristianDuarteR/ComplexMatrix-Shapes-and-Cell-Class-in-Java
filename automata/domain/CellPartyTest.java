package domain;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.Color;


public class CellPartyTest
{   
    @Test
    public void shouldCreateApartyCell(){
        CellParty prueba = new CellParty(new CellularAutomata(),5,5);
        assertEquals(prueba.nextState, Agent.ALIVE);
    }
    
    @Test
    public void shouldChangeHisColor(){
        CellularAutomata miAutomata = new CellularAutomata();
        CellParty prueba = new CellParty(miAutomata,5,5);
        Color color1 = prueba.getColor();
        prueba.decide();
        Color color2 = prueba.getColor();
        prueba.decide();
        Color color3 = prueba.getColor();
        
        assertFalse(color1.equals(color3));
    }
}
