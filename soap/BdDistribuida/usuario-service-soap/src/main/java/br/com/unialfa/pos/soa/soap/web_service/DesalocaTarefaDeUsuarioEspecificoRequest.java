//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.11.28 às 10:27:12 PM BRST 
//


package br.com.unialfa.pos.soa.soap.web_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuarioTarefaRemotaId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "usuarioTarefaRemotaId"
})
@XmlRootElement(name = "desalocaTarefaDeUsuarioEspecificoRequest")
public class DesalocaTarefaDeUsuarioEspecificoRequest {

    protected long usuarioTarefaRemotaId;

    /**
     * Obtém o valor da propriedade usuarioTarefaRemotaId.
     * 
     */
    public long getUsuarioTarefaRemotaId() {
        return usuarioTarefaRemotaId;
    }

    /**
     * Define o valor da propriedade usuarioTarefaRemotaId.
     * 
     */
    public void setUsuarioTarefaRemotaId(long value) {
        this.usuarioTarefaRemotaId = value;
    }

}
