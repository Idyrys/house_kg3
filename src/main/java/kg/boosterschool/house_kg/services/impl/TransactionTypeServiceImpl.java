package kg.boosterschool.house_kg.services.impl;

import kg.boosterschool.house_kg.models.TransactionType;
import kg.boosterschool.house_kg.repositories.TransactionTypeRepo;
import kg.boosterschool.house_kg.services.TransactionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {
    private final TransactionTypeRepo transactionTypeRepo;

    public TransactionTypeServiceImpl(TransactionTypeRepo transactionTypeRepo) {
        this.transactionTypeRepo = transactionTypeRepo;
    }

    @Override
    public List<TransactionType> getAllTransactionType() {
        return transactionTypeRepo.findAll();
    }

    @Override
    public TransactionType getReferenceById(Long id) {
        return transactionTypeRepo.getReferenceById(id);
    }
}
