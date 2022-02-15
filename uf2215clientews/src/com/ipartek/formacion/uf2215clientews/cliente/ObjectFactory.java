
package com.ipartek.formacion.uf2215clientews.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ipartek.formacion.uf2215clientews.cliente package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteCliente_QNAME = new QName("http://serviciosweb.uf2215.formacion.ipartek.com/", "deleteCliente");
    private final static QName _PostClienteResponse_QNAME = new QName("http://serviciosweb.uf2215.formacion.ipartek.com/", "postClienteResponse");
    private final static QName _GetClientesResponse_QNAME = new QName("http://serviciosweb.uf2215.formacion.ipartek.com/", "getClientesResponse");
    private final static QName _PostCliente_QNAME = new QName("http://serviciosweb.uf2215.formacion.ipartek.com/", "postCliente");
    private final static QName _GetClienteResponse_QNAME = new QName("http://serviciosweb.uf2215.formacion.ipartek.com/", "getClienteResponse");
    private final static QName _GetCliente_QNAME = new QName("http://serviciosweb.uf2215.formacion.ipartek.com/", "getCliente");
    private final static QName _DeleteClienteResponse_QNAME = new QName("http://serviciosweb.uf2215.formacion.ipartek.com/", "deleteClienteResponse");
    private final static QName _PutCliente_QNAME = new QName("http://serviciosweb.uf2215.formacion.ipartek.com/", "putCliente");
    private final static QName _GetClientes_QNAME = new QName("http://serviciosweb.uf2215.formacion.ipartek.com/", "getClientes");
    private final static QName _PutClienteResponse_QNAME = new QName("http://serviciosweb.uf2215.formacion.ipartek.com/", "putClienteResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ipartek.formacion.uf2215clientews.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetClientes }
     * 
     */
    public GetClientes createGetClientes() {
        return new GetClientes();
    }

    /**
     * Create an instance of {@link PutClienteResponse }
     * 
     */
    public PutClienteResponse createPutClienteResponse() {
        return new PutClienteResponse();
    }

    /**
     * Create an instance of {@link DeleteCliente }
     * 
     */
    public DeleteCliente createDeleteCliente() {
        return new DeleteCliente();
    }

    /**
     * Create an instance of {@link PostClienteResponse }
     * 
     */
    public PostClienteResponse createPostClienteResponse() {
        return new PostClienteResponse();
    }

    /**
     * Create an instance of {@link GetClientesResponse }
     * 
     */
    public GetClientesResponse createGetClientesResponse() {
        return new GetClientesResponse();
    }

    /**
     * Create an instance of {@link PostCliente }
     * 
     */
    public PostCliente createPostCliente() {
        return new PostCliente();
    }

    /**
     * Create an instance of {@link GetClienteResponse }
     * 
     */
    public GetClienteResponse createGetClienteResponse() {
        return new GetClienteResponse();
    }

    /**
     * Create an instance of {@link GetCliente }
     * 
     */
    public GetCliente createGetCliente() {
        return new GetCliente();
    }

    /**
     * Create an instance of {@link DeleteClienteResponse }
     * 
     */
    public DeleteClienteResponse createDeleteClienteResponse() {
        return new DeleteClienteResponse();
    }

    /**
     * Create an instance of {@link PutCliente }
     * 
     */
    public PutCliente createPutCliente() {
        return new PutCliente();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosweb.uf2215.formacion.ipartek.com/", name = "deleteCliente")
    public JAXBElement<DeleteCliente> createDeleteCliente(DeleteCliente value) {
        return new JAXBElement<DeleteCliente>(_DeleteCliente_QNAME, DeleteCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosweb.uf2215.formacion.ipartek.com/", name = "postClienteResponse")
    public JAXBElement<PostClienteResponse> createPostClienteResponse(PostClienteResponse value) {
        return new JAXBElement<PostClienteResponse>(_PostClienteResponse_QNAME, PostClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosweb.uf2215.formacion.ipartek.com/", name = "getClientesResponse")
    public JAXBElement<GetClientesResponse> createGetClientesResponse(GetClientesResponse value) {
        return new JAXBElement<GetClientesResponse>(_GetClientesResponse_QNAME, GetClientesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosweb.uf2215.formacion.ipartek.com/", name = "postCliente")
    public JAXBElement<PostCliente> createPostCliente(PostCliente value) {
        return new JAXBElement<PostCliente>(_PostCliente_QNAME, PostCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosweb.uf2215.formacion.ipartek.com/", name = "getClienteResponse")
    public JAXBElement<GetClienteResponse> createGetClienteResponse(GetClienteResponse value) {
        return new JAXBElement<GetClienteResponse>(_GetClienteResponse_QNAME, GetClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosweb.uf2215.formacion.ipartek.com/", name = "getCliente")
    public JAXBElement<GetCliente> createGetCliente(GetCliente value) {
        return new JAXBElement<GetCliente>(_GetCliente_QNAME, GetCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosweb.uf2215.formacion.ipartek.com/", name = "deleteClienteResponse")
    public JAXBElement<DeleteClienteResponse> createDeleteClienteResponse(DeleteClienteResponse value) {
        return new JAXBElement<DeleteClienteResponse>(_DeleteClienteResponse_QNAME, DeleteClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosweb.uf2215.formacion.ipartek.com/", name = "putCliente")
    public JAXBElement<PutCliente> createPutCliente(PutCliente value) {
        return new JAXBElement<PutCliente>(_PutCliente_QNAME, PutCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosweb.uf2215.formacion.ipartek.com/", name = "getClientes")
    public JAXBElement<GetClientes> createGetClientes(GetClientes value) {
        return new JAXBElement<GetClientes>(_GetClientes_QNAME, GetClientes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosweb.uf2215.formacion.ipartek.com/", name = "putClienteResponse")
    public JAXBElement<PutClienteResponse> createPutClienteResponse(PutClienteResponse value) {
        return new JAXBElement<PutClienteResponse>(_PutClienteResponse_QNAME, PutClienteResponse.class, null, value);
    }

}
