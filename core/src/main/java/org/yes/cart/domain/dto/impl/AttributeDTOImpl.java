package org.yes.cart.domain.dto.impl;

import dp.lib.dto.geda.annotations.Dto;
import dp.lib.dto.geda.annotations.DtoField;
import org.yes.cart.domain.dto.AttributeDTO;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 09-May-2011
 * Time: 14:12:54
 */
@Dto
public class AttributeDTOImpl  implements AttributeDTO {

    private static final long serialVersionUID = 20100717L;

    @DtoField(value = "attributeId")
    private long attributeId;
    

    @DtoField(value = "code")
    private String code;

    @DtoField(value = "mandatory")
    private boolean mandatory;

    @DtoField(value = "val")
    private String val;

    @DtoField(value = "name")
    private String name;

    @DtoField(value = "description")
    private String description;

    @DtoField(value = "etype.etypeId", readOnly=true)
    private long etypeId;

    @DtoField(value = "etype.businesstype", readOnly=true)
    private String etypeName;


    @DtoField(value = "attributeGroup.attributegroupId", readOnly=true)
    private long attributegroupId;

    @DtoField(value = "allowduplicate")
    private boolean allowduplicate;

    @DtoField(value = "allowfailover")
    private boolean allowfailover;


    @DtoField(value = "regexp")
    private String regexp;

    @DtoField(value = "validationFailedMessage")
    private String validationFailedMessage;

    @DtoField(value = "rank")
    private int rank;

    @DtoField(value = "choiceData")
    private String choiceData;

    /** {@inheritDoc} */
    public int getRank() {
        return rank;
    }

    /** {@inheritDoc} */
    public void setRank(final int rank) {
        this.rank = rank;
    }

    /** {@inheritDoc} */
    public String getChoiceData() {
        return choiceData;
    }

    /** {@inheritDoc} */
    public void setChoiceData(final String choiceData) {
        this.choiceData = choiceData;
    }

    /** {@inheritDoc} */
    public String getValidationFailedMessage() {
        return validationFailedMessage;
    }

    /** {@inheritDoc} */
    public void setValidationFailedMessage(final String validationFailedMessage) {
        this.validationFailedMessage = validationFailedMessage;
    }

    /** {@inheritDoc} */
    public long getAttributegroupId() {
        return attributegroupId;
    }

    /** {@inheritDoc} */
    public void setAttributegroupId(long attributegroupId) {
        this.attributegroupId = attributegroupId;
    }

    /** {@inheritDoc} */
    public long getAttributeId() {
        return this.attributeId;
    }

    /** {@inheritDoc} */
    public void setAttributeId(final long attributeId) {
        this.attributeId = attributeId;
    }

    /** {@inheritDoc} */
    public String getCode() {
        return code;
    }

    /** {@inheritDoc} */
    public void setCode(final String code) {
        this.code = code;
    }

    /** {@inheritDoc} */
    public boolean isMandatory() {
        return mandatory;
    }

    /** {@inheritDoc} */
    public void setMandatory(final boolean mandatory) {
        this.mandatory = mandatory;
    }

    /** {@inheritDoc} */
    public String getVal() {
        return val;
    }

    /** {@inheritDoc} */
    public void setVal(final String val) {
        this.val = val;
    }

    /** {@inheritDoc} */
    public String getName() {
        return name;
    }

    /** {@inheritDoc} */
    public void setName(final String name) {
        this.name = name;
    }

    /** {@inheritDoc} */
    public String getDescription() {
        return description;
    }

    /** {@inheritDoc} */
    public void setDescription(final String description) {
        this.description = description;
    }

    public long getEtypeId() {
        return etypeId;
    }

    /** {@inheritDoc} */
    public void setEtypeId(final long etypeId) {
        this.etypeId = etypeId;
    }

    /** {@inheritDoc} */
    public String getEtypeName() {
        return etypeName;
    }

    /** {@inheritDoc} */
    public void setEtypeName(final String etypeName) {
        this.etypeName = etypeName;
    }

    /** {@inheritDoc} */
    public boolean isAllowduplicate() {
        return allowduplicate;
    }

    /** {@inheritDoc} */
    public void setAllowduplicate(final boolean allowduplicate) {
        this.allowduplicate = allowduplicate;
    }

    /** {@inheritDoc} */
    public boolean isAllowfailover() {
        return allowfailover;
    }

    /** {@inheritDoc} */
    public void setAllowfailover(final boolean allowfailover) {
        this.allowfailover = allowfailover;
    }

    /** {@inheritDoc} */
    public String getRegexp() {
        return regexp;
    }

    /** {@inheritDoc} */
    public void setRegexp(final String regexp) {
        this.regexp = regexp;
    }
}