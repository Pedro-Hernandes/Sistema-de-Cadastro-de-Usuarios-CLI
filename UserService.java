package usermanagement;

import java.io.*;
import java.util.*;

/**
 * Serviço responsável por gerenciar usuários em memória
 * e persistir em arquivo texto (CSV).
 */
public class UserService {
    private final List<User> users = new ArrayList<>();
    private final File dataFile;
    private int nextId = 1;

    public UserService(String filename) {
        dataFile = new File(filename);
        loadUsers();
    }

    // Carrega usuários do arquivo (se existir)
    private void loadUsers() {
        if (!dataFile.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Cada linha: id;nome;email
                String[] parts = line.split(";", 3);
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String email = parts[2];
                    users.add(new User(id, name, email));
                    nextId = Math.max(nextId, id + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar usuários: " + e.getMessage());
        }
    }

    // Salva todos os usuários no arquivo
    public void saveUsers() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(dataFile))) {
            for (User u : users) {
                pw.printf("%d;%s;%s%n", u.getId(), u.getName(), u.getEmail());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    public List<User> listAll() {
        return Collections.unmodifiableList(users);
    }

    public User create(String name, String email) {
        User u = new User(nextId++, name, email);
        users.add(u);
        return u;
    }

    public boolean update(int id, String newName, String newEmail) {
        for (User u : users) {
            if (u.getId() == id) {
                u.SetName(newName);
                u.setEmail(newEmail);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return users.removeIf(u -> u.getId() == id);
    }

    public User findById(int id) {
        return users.stream()
            .filter(u -> u.getId() == id)
            .findFirst()
            .orElse(null);
    }
}
