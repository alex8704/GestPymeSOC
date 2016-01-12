/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "GPT_PROVEEDORES")
@DiscriminatorValue("PROVEEDOR")
@NamedQueries({
    @NamedQuery(name = "GptProvider.findAll", query = "SELECT g FROM GptProvider g")})
public class GptProvider extends MatThirdPerson {
}
