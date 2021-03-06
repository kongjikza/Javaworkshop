package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity   //�繡�ú͡��� Class �� Entity 
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")


public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer productid;
	private String productname;
	private ProductCategory productCategory;

	public Product() {
	}
	
	public Product(Integer productid) {
		this.productid = productid;
	}

	@Id  // �繡�ú͡����� primary key
	@Column(name = "productid", unique = true, nullable = false)  // �繡�ú͡���� map�Ѻ column ����
	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	@Column(name = "productname")
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryid")
	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
}