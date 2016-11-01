/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eagles.sabor_mel.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dhiego.balthazar
 */

@Entity
@Table(name = "venda")
public class Venda implements Serializable{
    
    @Id
    @SequenceGenerator(name = "idVenda", sequenceName="idvenda_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idVenda")
    @Column(name="idVenda", nullable=false)
    private Long idVenda;
    
    @Column(name = "dataVenda")
    @Temporal(TemporalType.DATE)
    private Calendar dataVenda;
    
    @Column(name = "tipoVenda")
    private String tipoVenda;
    
      
    @Column(name = "desconto")
    private Double desconto;
    
    @ManyToOne
    @JoinColumn(name="idPessoa", nullable=true)
    private Pessoa cliente;
    
    @ManyToOne
    @JoinColumn(name="idFuncionario", nullable=true)
    private Funcionario vendedor;
    
    @OneToMany(mappedBy = "venda", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<ItemVenda> itens;
    
    public Venda(){
        itens = new ArrayList<ItemVenda>();
    }

    public List<ItemVenda> getItens() {
        return itens;
    }
    
    public void addItem(ItemVenda item){
        item.setVenda(this);
        itens.add(item);
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Calendar getDataVenda() {
        return dataVenda;
    }

    public void setData(Calendar dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }
    
    
}
