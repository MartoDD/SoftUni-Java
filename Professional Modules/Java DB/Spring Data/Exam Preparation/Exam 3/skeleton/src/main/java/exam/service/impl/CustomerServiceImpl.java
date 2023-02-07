package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerDto;
import exam.repository.CustomerRepository;
import exam.service.CustomerService;
import exam.util.ValidationTool;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static exam.util.Paths.PATH_OF_CUSTOMERS;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ValidationTool validationTool;

    private final ModelMapper modelMapper;
    private final Gson gson;

    public CustomerServiceImpl(CustomerRepository customerRepository, ValidationTool validationTool, ModelMapper modelMapper, Gson gson) {
        this.customerRepository = customerRepository;
        this.validationTool = validationTool;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(PATH_OF_CUSTOMERS));
    }

    @Override
    public String importCustomers() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCustomersFileContent(), CustomerDto[].class))
                .filter(customerDto -> {

                    boolean isValid= validationTool.isValid(customerDto);
                })

        return null;
    }
}
