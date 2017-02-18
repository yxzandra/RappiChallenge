package com.rappi.challenge;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.robolectric.RuntimeEnvironment;

/**
 * Created by yxzan on 17/02/2017.
 */

public abstract class BaseTest {
    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        if (RuntimeEnvironment.application != null){

        }
    }
}
