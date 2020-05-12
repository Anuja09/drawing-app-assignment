package com.cs.config;

import com.cs.adaptors.Output;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ConfigurationTest {
    @InjectMocks
    private Configuration configuration;
    @Mock
    InputStream inputStream;

    @Test
    void shouldInitialize_configuration() {

        configuration.initialize();
        assertTrue(null != configuration.properties);
        assertTrue(Output.CONSOLE.name()
                .equals(configuration.properties.getProperty(Property.OUTPUT.name())));
    }

}