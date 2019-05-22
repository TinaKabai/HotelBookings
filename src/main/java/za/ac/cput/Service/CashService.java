package za.ac.cput.Service;

import za.ac.cput.Domain.Payment.Cash;

import java.util.Map;

public interface CashService extends IService<Cash, String> {

    Map<Cash, Cash> getAll();
}
