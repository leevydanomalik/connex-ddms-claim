/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.policy.transformheaders.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * @author Leevy D. Malik (leevy.malik at bitozen.id)
 * @author Angeline Merlin (angel.merlin at bitozen.id)
 * @author Bitozen Team
 */
public class TransformHeadersPolicyConfigurationTest {

    @Test
    public void test_transformHeaders01() throws IOException {
        TransformHeadersPolicyConfiguration configuration = load("/io/gravitee/policy/transformheaders/configuration/transformheaders01.json", TransformHeadersPolicyConfiguration.class);

        assertEquals(PolicyScope.REQUEST, configuration.getScope());
        assertNotNull(configuration.getAddHeaders());
        assertNotNull(configuration.getRemoveHeaders());
        assertNull(configuration.getWhitelistHeaders());

        assertEquals(1, configuration.getAddHeaders().size());
        assertEquals(1, configuration.getRemoveHeaders().size());
    }

    @Test
    public void test_transformHeaders02() throws IOException {
        TransformHeadersPolicyConfiguration configuration = load("/io/gravitee/policy/transformheaders/configuration/transformheaders02.json", TransformHeadersPolicyConfiguration.class);

        assertEquals(PolicyScope.RESPONSE, configuration.getScope());
        assertNotNull(configuration.getAddHeaders());
        assertNotNull(configuration.getRemoveHeaders());
        assertNull(configuration.getWhitelistHeaders());

        assertEquals(1, configuration.getAddHeaders().size());
        assertEquals(1, configuration.getRemoveHeaders().size());
    }

    @Test
    public void test_transformHeaders03() throws IOException {
        TransformHeadersPolicyConfiguration configuration = load("/io/gravitee/policy/transformheaders/configuration/transformheaders03.json", TransformHeadersPolicyConfiguration.class);

        assertEquals(PolicyScope.RESPONSE, configuration.getScope());
        assertNotNull(configuration.getAddHeaders());
        assertNotNull(configuration.getRemoveHeaders());
        assertNull(configuration.getWhitelistHeaders());

        assertEquals(2, configuration.getAddHeaders().size());
        assertEquals(1, configuration.getRemoveHeaders().size());
    }

    @Test
    public void test_transformHeaders04() throws IOException {
        TransformHeadersPolicyConfiguration configuration = load("/io/gravitee/policy/transformheaders/configuration/transformheaders04.json", TransformHeadersPolicyConfiguration.class);

        assertEquals(PolicyScope.RESPONSE, configuration.getScope());
        assertNull(configuration.getAddHeaders());
        assertNull(configuration.getRemoveHeaders());
        assertNotNull(configuration.getWhitelistHeaders());

        assertEquals(2, configuration.getWhitelistHeaders().size());
    }

    private <T> T load(String resource, Class<T> type) throws IOException {
        URL jsonFile = this.getClass().getResource(resource);
        return new ObjectMapper().readValue(jsonFile, type);
    }
}
