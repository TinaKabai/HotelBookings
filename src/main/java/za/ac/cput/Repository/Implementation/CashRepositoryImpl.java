package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Payment.Cash;
import za.ac.cput.Repository.CashRepository;

import java.util.HashSet;
import java.util.Set;

public class CashRepositoryImpl implements CashRepository {

    private static CashRepositoryImpl repository = null;
    private Set<Cash> cash;

    private CashRepositoryImpl() {
        this.cash = new HashSet<Cash>();
    }

    public static CashRepositoryImpl getRepository() {
        if (repository == null) repository = new CashRepositoryImpl();
        return repository;
    }
    public Cash create(Cash cash1) {
        this.cash.add(cash1);
        return cash1;
    }

    public Cash read(double amount) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(double amount) {
        // find the course, delete it if it exist
    }

    public Cash update(Cash cash1) {
        // find the course, update it and delete it if it exists
        return cash1;
    }

    public void delete(String s) {

    }

    public Cash read(String s) {
        return null;
    }

    public Set<Cash> getAll(){
        return this.cash;
    }
}
