package com.isa.jjdd.arquillian.ex03_arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class PostCarIT {

    @Inject
    PostCar postCar;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(PostCar.class, GasStation.class, FuelTank.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void shouldInjectPostCar() {
        // given

        // when

        // then
        assertNotNull(postCar);
    }


    @Test
    public void shouldFill100LitersWhenTank() throws Exception {
        // given

        // when

        // then

    }
}
