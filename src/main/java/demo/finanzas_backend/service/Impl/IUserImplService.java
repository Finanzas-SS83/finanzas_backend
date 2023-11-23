package demo.finanzas_backend.service.Impl;

import demo.finanzas_backend.entities.users;
import demo.finanzas_backend.repository.IusersRepository;
import demo.finanzas_backend.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public  class IUserImplService implements IUserService {
    private  final IusersRepository iusersRepository;

    public IUserImplService(IusersRepository iusersRepository) {
        this.iusersRepository = iusersRepository;
    }
@Override
@Transactional
    public users save(users user)  {
        return iusersRepository.save(user);
    }

    @Override
    public void delete(Long id) throws Exception {
        iusersRepository.deleteById(id);
    }

    public users findByEmail(String email)  {
        return iusersRepository.findByEmail(email);
    }
    public List<users> getAll()  {
        return iusersRepository.findAll();
    }


    @Override
    public users getById(Long id) throws Exception {
        return iusersRepository.findById(id).orElseThrow(()->new Exception("El usuario no existe"));
    }

}
