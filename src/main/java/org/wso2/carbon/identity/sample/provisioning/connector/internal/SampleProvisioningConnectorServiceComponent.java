package org.wso2.carbon.identity.sample.provisioning.connector.internal;

import org.wso2.carbon.identity.sample.provisioning.connector.SampleProvisioningConnectorFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.identity.provisioning.AbstractProvisioningConnectorFactory;

/**
 * @scr.component name="SampleProvisioningConnectorServiceComponent"
 * immediate="true"
 */
public class SampleProvisioningConnectorServiceComponent {

    private static Log log = LogFactory.getLog(SampleProvisioningConnectorServiceComponent.class);

    protected void activate(ComponentContext context) {

        if (log.isDebugEnabled()) {
            log.debug("SampleProvisioningConnectorServiceComponent");
        }

        try {
            SampleProvisioningConnectorFactory provisioningConnectorFactory = new SampleProvisioningConnectorFactory();

            context.getBundleContext()
                    .registerService(AbstractProvisioningConnectorFactory.class.getName(), provisioningConnectorFactory,
                            null);
            if (log.isDebugEnabled()) {
                log.debug("Identity Provisioning Connector bundle is activated");
            }
        } catch (Throwable e) {
            log.error(" Error while activating Identity Provisioning Connector ", e);
        }
    }
}
