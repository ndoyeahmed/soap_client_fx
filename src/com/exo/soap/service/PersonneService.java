
package com.exo.soap.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonneService", targetNamespace = "http://service.soap.exo.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonneService {


    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addPersonne", targetNamespace = "http://service.soap.exo.com/", className = "com.exo.soap.service.AddPersonne")
    @ResponseWrapper(localName = "addPersonneResponse", targetNamespace = "http://service.soap.exo.com/", className = "com.exo.soap.service.AddPersonneResponse")
    @Action(input = "http://service.soap.exo.com/PersonneService/addPersonneRequest", output = "http://service.soap.exo.com/PersonneService/addPersonneResponse")
    public boolean addPersonne(
        @WebParam(name = "arg0", targetNamespace = "")
        Personne arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deletePersonne", targetNamespace = "http://service.soap.exo.com/", className = "com.exo.soap.service.DeletePersonne")
    @ResponseWrapper(localName = "deletePersonneResponse", targetNamespace = "http://service.soap.exo.com/", className = "com.exo.soap.service.DeletePersonneResponse")
    @Action(input = "http://service.soap.exo.com/PersonneService/deletePersonneRequest", output = "http://service.soap.exo.com/PersonneService/deletePersonneResponse")
    public boolean deletePersonne(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.exo.soap.service.Personne
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPersonneById", targetNamespace = "http://service.soap.exo.com/", className = "com.exo.soap.service.GetPersonneById")
    @ResponseWrapper(localName = "getPersonneByIdResponse", targetNamespace = "http://service.soap.exo.com/", className = "com.exo.soap.service.GetPersonneByIdResponse")
    @Action(input = "http://service.soap.exo.com/PersonneService/getPersonneByIdRequest", output = "http://service.soap.exo.com/PersonneService/getPersonneByIdResponse")
    public Personne getPersonneById(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

    /**
     * 
     * @return
     *     returns java.util.List<com.exo.soap.service.Personne>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "personneList", targetNamespace = "http://service.soap.exo.com/", className = "com.exo.soap.service.PersonneList")
    @ResponseWrapper(localName = "personneListResponse", targetNamespace = "http://service.soap.exo.com/", className = "com.exo.soap.service.PersonneListResponse")
    @Action(input = "http://service.soap.exo.com/PersonneService/personneListRequest", output = "http://service.soap.exo.com/PersonneService/personneListResponse")
    public List<Personne> personneList();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updatePersonne", targetNamespace = "http://service.soap.exo.com/", className = "com.exo.soap.service.UpdatePersonne")
    @ResponseWrapper(localName = "updatePersonneResponse", targetNamespace = "http://service.soap.exo.com/", className = "com.exo.soap.service.UpdatePersonneResponse")
    @Action(input = "http://service.soap.exo.com/PersonneService/updatePersonneRequest", output = "http://service.soap.exo.com/PersonneService/updatePersonneResponse")
    public boolean updatePersonne(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Personne arg1);

}
