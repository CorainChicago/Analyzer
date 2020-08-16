//package com.project.language.analyzer;
//
//
//import com.project.language.analyzer.model.AnalyzeRequest;
//import com.project.language.analyzer.repository.AnalysisResponseRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.reactive.server.WebTestClient;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
//public class AnalyzerControllerTest {
//
//    @Autowired
//    private WebTestClient client;
//
//    @MockBean
//    private AnalysisResponseRepository repository;
//
//    @Test
//    public void test(){
//
//        var request = new AnalyzeRequest(
//                "test",
//                "KMZ 2015 LIEZVIZ UZLZDUIM KMDK LZK KMZ EVKZUVZK DXFGG EVISFQZQ D LFCZU DVKEXEHKEI, CSDLKEIL CHSSFKEHV EV KMZ HIZDV, ISENDKZ IMDVWZ, DVQ LCZIEZL ZOKEVIKEHV, DIIHUQEVW KH DSKNZKUEI, D LKDUK-FC KMDK DVDSRGZL HVSEVZ DIKEPEKR LFUUHFVQEVW DIDQZNEI CDCZUL UZLZDUIM VZPZU UZLKL: ZPZUR RZDU KMHFLDVQL HA LIEZVKEAEI DUKEISZL DUZ CFXSELMZQ DIUHLL QHGZVL HA BHFUVDSL DVQ QELIECSEVZL. LHNZ LKFQEZL IDCKFUZ KMZ NZQEDâ??L DKKZVKEHV DVQ WZK IHPZUDWZ EV VFNZUHFL VZJL LKHUEZL; HKMZUL LCZDY KH D NHUZ VEIMZ DFQEZVIZ DVQ KDYZ HAA EV CDLLEHVDKZ LHIEDS NZQED QELIFLLEHVL. AHU KMZ LZIHVQ RZDU DSKNZKUEI MDL IHNCESZQ D SELK HA KMZ KHC 100 DIDQZNEI DUKEISZL HA KMZ RZDU. KMZR LKFQEZQ KMZ DKKZVKEHV WDUVZUZQ XR LIEZVKEAEI DUKEISZL AUHN VHPZNXZU 2014 FC FVKES VHPZNXZU 16, 2015, ZODNEVEVW MHJ CDCZUL ADUZQ EV VZJL IHPZUDWZ DVQ LHIEDS NZQED HFKSZKL LFIM DL KJEKKZU, ADIZXHHY, DVQ KMZ CHCFSDU IMEVZLZ NEIUHXSHWWEVW LEKZ LEVD JZEXH. KMZR DSLH SHHYZQ KH LZZ EA LKFQEZL JZUZ UZAZUZVIZQ XR JEYECZQED DVQ CHSEIR CDCZUL HFKSEVEVW CSDVL HA DIKEHVL JUEKKZV XR DVDSRLKL DVQ KMEVY KDVYL.",
//                true,
//                true);
//        this.client.get()
//                .uri("/")
//                .exchange()
//                .expectStatus().is2xxSuccessful()
//                .expectBody()
//                .jsonPath("$.name").isEqualTo("test");
//    }
//
//
//}
