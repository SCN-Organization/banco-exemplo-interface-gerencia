package br.ufrpe.poo.banco.negocio;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufrpe.poo.banco.exceptions.SaldoInsuficienteException;

public class TesteConta2 {

    /**
     * Debitar exatamente o saldo deve deixar o saldo em zero e não deve lançar exceção.
     */
    @Test
    public void debitarValorIgualAoSaldoDeixaZero() {
        Conta c = new Conta("A1", 150.0);
        try {
            c.debitar(150.0);
        } catch (SaldoInsuficienteException e) {
            fail("Não deveria lançar exceção quando debita exatamente o saldo");
        }
        assertEquals(0.0, c.getSaldo(), 0.0);
    }

    /**
     * Debitar 0 não deve alterar o saldo.
     */
    @Test
    public void debitarZeroNaoAlteraSaldo() {
        Conta c = new Conta("A2", 200.0);
        try {
            c.debitar(0.0);
        } catch (SaldoInsuficienteException e) {
            fail("Não deveria lançar exceção ao debitar zero");
        }
        assertEquals(200.0, c.getSaldo(), 0.0);
    }

    /**
     * Creditar 0 não deve alterar o saldo.
     */
    @Test
    public void creditarZeroNaoAlteraSaldo() {
        Conta c = new Conta("A3", 500.0);
        c.creditar(0.0);
        assertEquals(500.0, c.getSaldo(), 0.0);
    }

    /**
     * Observação sobre comportamento atual: debitar um valor negativo, dada a implementação atual de
     * Conta.debitar, acaba incrementando o saldo (porque subtrai um negativo). O teste documenta o
     * comportamento atual e verifica o resultado.
     *
     * Se preferir que debitar valor negativo seja proibido, a implementação da classe Conta deveria
     * ser ajustada; este teste serve para detectar regressão caso isso seja alterado.
     */
    @Test
    public void debitarValorNegativoAumentaSaldo_atualComportamento() {
        Conta c = new Conta("A4", 100.0);
        try {
            c.debitar(-50.0); // comportamento atual: saldo vira 150.0
        } catch (SaldoInsuficienteException e) {
            fail("Não deveria lançar exceção ao debitar valor negativo com a implementação atual");
        }
        assertEquals(150.0, c.getSaldo(), 0.0);
    }

    /**
     * Testa que a exceção SaldoInsuficienteException contém a mensagem formatada esperada.
     */
    @Test
    public void debitarSaldoInsuficienteMensagem() {
        Conta c = new Conta("123", 300.0);
        try {
            c.debitar(301.0);
            fail("Esperava SaldoInsuficienteException");
        } catch (SaldoInsuficienteException e) {
            String esperado = String.format("Saldo insuficiente! O saldo atual da conta %s eh R$%.2f",
                    c.getNumero(), c.getSaldo());
            assertEquals(esperado, e.getMessage());
        }
    }
}
