package com.avaliacao.projetoindividualcontinuada2.gravacao;

public class ListaObj<T> {

    private T[] vetor;
    private int nElemento;

    public ListaObj(int tamanho) {
        vetor = (T[]) new Object[tamanho];
        nElemento = 0;
    }

    public Boolean adiciona(T v) {
        if (nElemento < vetor.length) {
            vetor[nElemento] = v;
            nElemento++;
            return true;
        }
        return false;
    }

    public void exibe() {
        if (nElemento != 0) {
            System.out.println("[");
            for (int i = 0; i < nElemento; i++) {
                System.out.println("\t" + vetor[i] + (i < (nElemento - 1) ? "," : ""));
            }
            System.out.println("]");
        } else {
            System.out.println("\nLista está vazia");
        }
    }

    public Integer busca(T v) {
        if (nElemento != 0) {
            for (int i = 0; i < nElemento; i++) {
                if (vetor[i].equals(v))
                    return i;
            }
        }
        return -1;
    }

    public Boolean removePeloIndice(int index) {
        if (index >= 0 || index < nElemento) {
            for (int i = index; i < nElemento - 1; i++)
                vetor[i] = vetor[i + 1];
            nElemento--;
            return true;
        }
        return false;
    }

    public boolean removeElemento(T index) {
        return removePeloIndice(busca(index));
    }

    public Integer getTamanho() {
        return nElemento;
    }

    public Integer contaOcorrencias(int v){
        Integer contar = 0;
        for (int i = 0; i < nElemento; i++) {
            if(i == v){
                contar++;
            }
        }
        return contar;
    }

    public T getElemento(int index) {
        if (index < 0 || index >= nElemento)
            return null;
        return vetor[index];
    }
    public Boolean substitui(T v1, T v2) {
        vetor[busca(v1)] = v2;
        return false;
    }

    public void limpa() {
        nElemento = 0;
    }
}
