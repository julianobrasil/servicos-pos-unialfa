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
 *         &lt;element name="tarefaRemotaId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "tarefaRemotaId"
})
@XmlRootElement(name = "desalocaTarefaDeTodosOsUsuariosRequest")
public class DesalocaTarefaDeTodosOsUsuariosRequest {

    protected long tarefaRemotaId;

    /**
     * Obtém o valor da propriedade tarefaRemotaId.
     * 
     */
    public long getTarefaRemotaId() {
        return tarefaRemotaId;
    }

    /**
     * Define o valor da propriedade tarefaRemotaId.
     * 
     */
    public void setTarefaRemotaId(long value) {
        this.tarefaRemotaId = value;
    }

}
