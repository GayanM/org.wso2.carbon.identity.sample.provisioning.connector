package org.wso2.carbon.identity.sample.provisioning.connector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.common.model.Property;
import org.wso2.carbon.identity.provisioning.AbstractOutboundProvisioningConnector;
import org.wso2.carbon.identity.provisioning.IdentityProvisioningConstants;
import org.wso2.carbon.identity.provisioning.IdentityProvisioningException;
import org.wso2.carbon.identity.provisioning.ProvisionedIdentifier;
import org.wso2.carbon.identity.provisioning.ProvisioningEntity;

import java.util.Properties;

/**
 * Provision user by invoking update contact service
 * Update provisioned user by invoking ISUpdateContactOptOutOptionsServiceS
 */
public class SampleProvisioningConnector extends AbstractOutboundProvisioningConnector {

    private static final long serialVersionUID = 8465869197181038555L;

    private static final Log log = LogFactory.getLog(SampleProvisioningConnector.class);
    private Properties configs;

    @Override
    public void init(Property[] provisioningProperties) throws IdentityProvisioningException {

        Properties configs = new Properties();
        if (provisioningProperties != null && provisioningProperties.length > 0) {
            for (Property property : provisioningProperties) {
                configs.put(property.getName(), property.getValue());
                if (IdentityProvisioningConstants.JIT_PROVISIONING_ENABLED.equals(property.getName()) && "1"
                        .equals(property.getValue())) {
                    jitProvisioningEnabled = true;
                }
            }
        }
        this.configs = configs;
    }

    @Override
    public ProvisionedIdentifier provision(ProvisioningEntity provisioningEntity)
            throws IdentityProvisioningException {

        String provisionedId = null;

        if (provisioningEntity != null) {

            if (provisioningEntity.isJitProvisioning() && !isJitProvisioningEnabled()) {
                log.debug("JIT provisioning disabled for Sample connector");
                return null;
            }
        }
        // creates a provisioned identifier for the provisioned user.
        ProvisionedIdentifier identifier = new ProvisionedIdentifier();
        identifier.setIdentifier(provisionedId);
        return identifier;
    }
}
