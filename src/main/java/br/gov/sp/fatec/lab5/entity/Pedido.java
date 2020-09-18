package br.gov.sp.fatec.lab5.entity;


import javax.persistence.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Entity
@Table(name = "ped_pedido")

@AttributeOverride(name = "id", column = @Column(name = "ped_id"))
public class Pedido extends Identificador{

    public Pedido(){
    }
    public Pedido(Cliente cliente, Date dataDaCompra){
        setCliente(cliente);
        setDataDaCompra(dataDaCompra);
    }

    public void setDataDaCompra(Date dataDaCompra) {
        this.dataDaCompra=dataDaCompra;
    }

    public Date getDataDaCompra(){
        return dataDaCompra;
    }

    public void setCliente(Cliente cliente){
        this.cliente=cliente;
    }
    public Cliente getCliente(){
        return cliente;
    }
    

    public boolean add(Pagamento arg0) {
		return pagamentos.add(arg0);
	}

	public boolean addAll(Collection<? extends Pagamento> arg0) {
		return pagamentos.addAll(arg0);
	}

	public void clear() {
		pagamentos.clear();
	}

	public boolean contains(Object arg0) {
		return pagamentos.contains(arg0);
	}

	public boolean containsAll(Collection<?> arg0) {
		return pagamentos.containsAll(arg0);
	}

	public boolean equals(Object arg0) {
		return pagamentos.equals(arg0);
	}

	public void forEach(Consumer<? super Pagamento> arg0) {
		pagamentos.forEach(arg0);
	}

	public int hashCode() {
		return pagamentos.hashCode();
	}

	public boolean isEmpty() {
		return pagamentos.isEmpty();
	}

	public Iterator<Pagamento> iterator() {
		return pagamentos.iterator();
	}

	public Stream<Pagamento> parallelStream() {
		return pagamentos.parallelStream();
	}

	public boolean remove(Object arg0) {
		return pagamentos.remove(arg0);
	}

	public boolean removeAll(Collection<?> arg0) {
		return pagamentos.removeAll(arg0);
	}

	public boolean removeIf(Predicate<? super Pagamento> arg0) {
		return pagamentos.removeIf(arg0);
	}

	public boolean retainAll(Collection<?> c) {
		return pagamentos.retainAll(c);
	}

	public int size() {
		return pagamentos.size();
	}

	public Spliterator<Pagamento> spliterator() {
		return pagamentos.spliterator();
	}

	public Stream<Pagamento> stream() {
		return pagamentos.stream();
	}

	public Object[] toArray() {
		return pagamentos.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return pagamentos.toArray(a);
	}

	@ManyToOne
    @JoinColumn(name = "cli_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    private Set<ItemPedido> items = new HashSet<>();

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    private Set<Pagamento> pagamentos = new HashSet<>();

    @Column(name = "data_do_pedido")
    private Date dataDaCompra;

    public void addItemPedido(ItemPedido itemPedido){
        items.add(itemPedido);
    }

    public double getValorTotal() {
        return items.stream().mapToDouble(ItemPedido::getValorTotal).sum();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "items=" + items +
                ", id=" + id +
                '}';
    }

    public void setItems(Set<ItemPedido> itemPedidos) {
        this.items=itemPedidos;
    }

    public Long getId() {
        return id;
    }
    
}
