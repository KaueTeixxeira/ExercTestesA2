import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {

    private ContaBancaria contaBancaria;

    @BeforeEach
    public void setUp(){
        contaBancaria = new ContaBancaria("1","Kauê");
    }

    @Test
    public void retornaConta(){
        assertEquals("1",contaBancaria.getNumeroConta());
    }

    @Test
    public void retornaTitular(){
        assertEquals("Kauê",contaBancaria.getTitular());
    }

    @Test
    public void retornaSaldo(){
        assertEquals(0,contaBancaria.getSaldo());
    }

    @Test
    public void retornaTaxaJuros(){
        assertEquals(0,contaBancaria.getTaxaJuros());
    }

    @Test
    public void setTaxaJuros(){
        contaBancaria.setTaxaJuros(2);
        assertEquals(2,contaBancaria.getTaxaJuros());
    }

    @Test
    public void depositarDinheiro(){
        assertTrue(contaBancaria.depositar(100));
        assertFalse(contaBancaria.depositar(-100));
        assertFalse(contaBancaria.depositar(0));
    }

    @Test
    public void sacarDinheiro(){
        contaBancaria.depositar(200);
        assertTrue(contaBancaria.sacar(100));// Retirando 100
        assertTrue(contaBancaria.sacar(100));// Retirando valor == saldo
        assertFalse(contaBancaria.sacar(200));
        assertFalse(contaBancaria.sacar(0));
    }

    @Test
    public void tranferirDinheiro(){
        contaBancaria.depositar(200);
        ContaBancaria contaTransferir = new ContaBancaria("2", "John Wick");
        assertTrue(contaBancaria.transferir(contaTransferir,100));
        assertFalse(contaBancaria.transferir(contaTransferir,200));
    }

    @Test
    public void aplicaJuros(){
        contaBancaria.depositar(200);
        contaBancaria.setTaxaJuros(0.1);
        contaBancaria.aplicarJuros();
        assertEquals(220,contaBancaria.getSaldo());
    }

    @Test
    public void alteraTitular(){
        assertTrue(contaBancaria.alterarTitular("Kauê2"));
        assertEquals("Kauê2",contaBancaria.getTitular());
        assertFalse(contaBancaria.alterarTitular(""));
        assertFalse(contaBancaria.alterarTitular("     "));
    }


}
