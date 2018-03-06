package org.wso2.carbon.identity.sample.provisioning.connector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.common.model.Property;
import org.wso2.carbon.identity.provisioning.AbstractOutboundProvisioningConnector;
import org.wso2.carbon.identity.provisioning.AbstractProvisioningConnectorFactory;
import org.wso2.carbon.identity.provisioning.IdentityProvisioningException;

import java.util.ArrayList;
import java.util.List;

public class SampleProvisioningConnectorFactory extends AbstractProvisioningConnectorFactory {

    private static final Log log = LogFactory.getLog(SampleProvisioningConnectorFactory.class);
    private static final String SAMPLE = "SAMPLE";

    @Override
    protected AbstractOutboundProvisioningConnector buildConnector(Property[] provisioningProperties)
                                                                                throws IdentityProvisioningException {
        SampleProvisioningConnector connector = new SampleProvisioningConnector();
        connector.init(provisioningProperties);

        if (log.isDebugEnabled()) {
            log.debug("Sample provisioning connector created successfully.");
        }

        return connector;
    }

    @Override
    public String getConnectorType() {
        return SAMPLE;
    }


    public List<Property> getConfigurationProperties() {

        List<Property> properties = new ArrayList<Property>();

        Property nonAusServiceEP = new Property();
        nonAusServiceEP.setName(SampleProvisioningConnectorConstants.PROPERTY_NON_AUS_SERVICE_ENDPOINT);
        nonAusServiceEP.setDisplayName("Non AUS Provisioning Service Endpoint");
        nonAusServiceEP.setDescription("Service endpoint for non AUS user provisioning service");
        nonAusServiceEP.setDefaultValue("");
        nonAusServiceEP.setRequired(true);

        Property nonAusServiceUser = new Property();
        nonAusServiceUser.setName(SampleProvisioningConnectorConstants.PROPERTY_NON_AUS_SERVICE_USERNAME);
        nonAusServiceUser.setDisplayName("Non AUS Provisioning Service Username");
        nonAusServiceUser.setDescription("Username for non AUS user provisioning service");
        nonAusServiceUser.setDefaultValue("");
        nonAusServiceUser.setRequired(true);


        Property nonAusServicePassword = new Property();
        nonAusServicePassword.setName(SampleProvisioningConnectorConstants.PROPERTY_NON_AUS_SERVICE_PASSWORD);
        nonAusServicePassword.setDisplayName("Non AUS Provisioning Service Password");
        nonAusServicePassword.setConfidential(true);

        Property ausServiceEP = new Property();
        ausServiceEP.setName(SampleProvisioningConnectorConstants.PROPERTY_AUS_SERVICE_ENDPOINT);
        ausServiceEP.setDisplayName("AUS Provisioning Service Endpoint");
        ausServiceEP.setDescription("Service endpoint for AUS user provisioning service");
        ausServiceEP.setDefaultValue("");
        ausServiceEP.setRequired(true);

        Property ausServiceUser = new Property();
        ausServiceUser.setName(SampleProvisioningConnectorConstants.PROPERTY_AUS_SERVICE_USERNAME);
        ausServiceUser.setDisplayName("AUS Provisioning Service Username");
        ausServiceUser.setDescription("Username for AUS user provisioning service");
        ausServiceUser.setDefaultValue("");
        ausServiceUser.setRequired(true);


        Property ausServicePassword = new Property();
        ausServicePassword.setName(SampleProvisioningConnectorConstants.PROPERTY_AUS_SERVICE_PASSWORD);
        ausServicePassword.setDisplayName("AUS Provisioning Service Password");
        ausServicePassword.setConfidential(true);
		
		Property ausCountryValue = new Property();
        ausCountryValue.setName(SampleProvisioningConnectorConstants.PROPERTY_AUS_COUNTRY_NAME);
        ausCountryValue.setDisplayName("Value to consider the user is from Australia");
        ausCountryValue.setDefaultValue("AU");


        properties.add(nonAusServiceEP);
        properties.add(nonAusServiceUser);
        properties.add(nonAusServicePassword);
        properties.add(ausCountryValue);
        properties.add(ausServiceEP);
        properties.add(ausServiceUser);
        properties.add(ausServicePassword);

        return properties;
    }

}
