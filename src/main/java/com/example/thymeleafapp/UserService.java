package com.example.thymeleafapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public boolean loginUser(String email, String password, HttpSession session) {
        List<UserModel> listOfUser = userRepository.findAll();
        int flag = 0;
        for (UserModel u : listOfUser) {
            if (u.getEmail().equals(email) && u.getUserpassword().equals(password)) {
                session.setAttribute("currentUser", u);
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            return true;
        return false;
    }

    public void signupUser(UserModel u) {
        List<UserModel> listOfUser = userRepository.findAll();
        u.setUserid(listOfUser.size() + 1);
        this.userRepository.save(u);
    }

    public Integer findMaxId() {
        Integer id = 0;
        List<UserModel> listOfUser = userRepository.findAll();
        for (UserModel u :
                listOfUser) {
            if (u.getUserid() > id) {
                id = u.getUserid();
            }
        }
        ++id;
        return id;
    }

    private byte[] readFile(String fileName) {
        File file = new File(fileName);
        FileInputStream fin = null;
        try {
            // create FileInputStream object
            fin = new FileInputStream(file);
            byte fileContent[] = new byte[(int) file.length()];
            // Reads up to certain bytes of data from this input stream into an array of bytes.
            fin.read(fileContent);
            //create string from byte array
            return fileContent;
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading file " + ioe);
        } finally {
            // close the streams using close method
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error while closing stream: " + ioe);
            }
            return null;
        }
    }

    private BufferedImage createImageFromBytes(byte[] imageData) {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String saveImage(MultipartFile imageFile) {
        if (HomeController.getUserSession() == null) {
            try {
                String folder = System.getProperty("user.dir");
                folder += "/src/main/resources/static/images/";
                System.out.println(folder);
                File file = new File(folder + findMaxId().toString() + imageFile.getOriginalFilename());
                imageFile.transferTo(file);
                return "/images/" + findMaxId().toString() + imageFile.getOriginalFilename();
            } catch (Exception e) {
                System.out.println("Error saving photo!");
                System.out.println(e.getMessage());
            }
            return "";
        }
        try {
            UserModel u = (UserModel) HomeController.getUserSession().getAttribute("currentUser");
            String folder = System.getProperty("user.dir");
            folder += "/src/main/resources/static/images/";
            System.out.println(folder);
            File file = new File(folder + u.getUserid().toString() +imageFile.getOriginalFilename());
            imageFile.transferTo(file);
            return "/images/" + u.getUserid().toString() + imageFile.getOriginalFilename();
        } catch (Exception e) {
            System.out.println("Error saving photo!");
            System.out.println(e.getMessage());
        }
        return "";

    }
}
