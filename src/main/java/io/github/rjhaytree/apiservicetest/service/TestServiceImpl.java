package io.github.rjhaytree.apiservicetest.service;

import io.github.rjhaytree.apiservicetest.APIServiceTest;

public class TestServiceImpl implements TestService {
    private APIServiceTest plugin;

    public TestServiceImpl(APIServiceTest plugin) {
        this.plugin = plugin;
    }

    @Override
    public void printTest() {

    }
}
