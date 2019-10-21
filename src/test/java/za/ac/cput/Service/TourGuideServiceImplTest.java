package za.ac.cput.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.Domain.Tour.TourGuide;
import za.ac.cput.Factory.TourGuideFactory;
import za.ac.cput.Service.Tour.implementations.TourGuideServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TourGuideServiceImplTest{

    @Autowired
    private TourGuideServiceImpl service;
    private List<TourGuide> classes;
    TourGuide tgl;
    TourGuide tg2;

    @Before
    public void setUp() throws Exception {

    }

}