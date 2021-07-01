package home.holytiger.dynamicdatabase.testDomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestMapper testMapper;

    @Override
    public String comInfo() {
        return testMapper.comInfo();
    }
}
