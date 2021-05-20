package guru.springframework.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated banco ID")
    private Integer id;
    @Version
    @ApiModelProperty(notes = "The auto-generated version of the banco")
    private Integer version;
    @ApiModelProperty(notes = "The application-specific banco ID")
    private Integer nroCuenta;
    @ApiModelProperty(notes = "The banco description")
    private String description;
    @ApiModelProperty(notes = "The image URL of the banco")
    private String imageUrl;
    @ApiModelProperty(notes = "The price of the banco", required = true)
    private BigDecimal saldo;
    
    
 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(Integer nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}
