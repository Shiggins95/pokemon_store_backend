package com.stephenhiggins.pokemon_store_backend.components;

import com.stephenhiggins.pokemon_store_backend.models.Product;
import com.stephenhiggins.pokemon_store_backend.models.User;
import com.stephenhiggins.pokemon_store_backend.repos.ProductRepo;
import com.stephenhiggins.pokemon_store_backend.repos.UserRepo;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

@Component
public class UserLoader implements ApplicationRunner {
  @Autowired UserRepo userRepo;
  @Autowired ProductRepo productrepo;

  public UserLoader() {}

  public void run(ApplicationArguments args) throws NoSuchAlgorithmException {
    User user1 = new User("stephen.higgins1995@gmail.com", "Password123");
    userRepo.save(user1);
    JSONArray images = new JSONArray();
    images.appendElement("https://i.ibb.co/j57jmVx/2018legendsthumb.png");
    images.appendElement("https://i.ibb.co/rszfnqw/ash-Cap-Pikachus.png");
    images.appendElement("https://i.ibb.co/6H4fLTs/all-Dream-World-Thumb.png");
    images.appendElement("https://image.ibb.co/bZj50e/thumb4-3.png");
    images.appendElement("https://image.ibb.co/cviLYz/thumb4-4.png");

    Product product1 =
        new Product(
            "10 Custom Pokemon",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore iure provident in pariatur voluptatibus labore perspiciatis reiciendis, eligendi delectus cupiditate at, doloremque earum? Ipsam vitae, soluta a inventore. Quidem, ipsum. Esse expedita a, cupiditate nesciunt dolores! Facilis hic nemo explicabo iure eveniet non dignissimos, velit facere, consequuntur, debitis cum. Aspernatur aut repellat consectetur dolorem nulla asperiores odit vero, necessitatibus possimus, autem, delectus et. Fuga corrupti aliquid ipsa odit nihil inventore eos iusto, ullam dolorem quidem animi accusamus, beatae aspernatur laborum deleniti. Quaerat, nobis, dolorum. Tenetur saepe velit at quae enim accusamus labore qui voluptatum, mollitia nobis cupiditate blanditiis iure eaque repellendus quam facilis temporibus reiciendis deserunt, quibusdam in, ipsa. Sunt officia architecto similique in corrupti voluptatibus fugit consectetur explicabo saepe dignissimos ex adipisci voluptate dicta at eius inventore quasi omnis nulla cum, culpa odio cupiditate. Sapiente quia architecto, suscipit, laboriosam natus reiciendis soluta alias vero praesentium deleniti sit fugiat culpa nemo, consequuntur explicabo nulla velit distinctio cupiditate! Iure, modi quaerat a dignissimos deleniti natus iusto, aut quisquam deserunt inventore praesentium provident libero architecto. Ipsam expedita nesciunt, maiores voluptatibus sed velit fugiat nam et earum blanditiis voluptate voluptates quisquam, autem eos mollitia. Aliquid natus sunt, accusamus autem blanditiis impedit quaerat iure.",
            0.99,
            "package",
            17,
            "https://image.ibb.co/mbVHDz/thumb10.png",
            images.toString());
    product1.setUser(user1);
    user1.addToProducts(product1);
    productrepo.save(product1);
    Product product2 =
        new Product(
            "20 Custom Pokemon",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore iure provident in pariatur voluptatibus labore perspiciatis reiciendis, eligendi delectus cupiditate at, doloremque earum? Ipsam vitae, soluta a inventore. Quidem, ipsum. Esse expedita a, cupiditate nesciunt dolores! Facilis hic nemo explicabo iure eveniet non dignissimos, velit facere, consequuntur, debitis cum. Aspernatur aut repellat consectetur dolorem nulla asperiores odit vero, necessitatibus possimus, autem, delectus et. Fuga corrupti aliquid ipsa odit nihil inventore eos iusto, ullam dolorem quidem animi accusamus, beatae aspernatur laborum deleniti. Quaerat, nobis, dolorum. Tenetur saepe velit at quae enim accusamus labore qui voluptatum, mollitia nobis cupiditate blanditiis iure eaque repellendus quam facilis temporibus reiciendis deserunt, quibusdam in, ipsa. Sunt officia architecto similique in corrupti voluptatibus fugit consectetur explicabo saepe dignissimos ex adipisci voluptate dicta at eius inventore quasi omnis nulla cum, culpa odio cupiditate. Sapiente quia architecto, suscipit, laboriosam natus reiciendis soluta alias vero praesentium deleniti sit fugiat culpa nemo, consequuntur explicabo nulla velit distinctio cupiditate! Iure, modi quaerat a dignissimos deleniti natus iusto, aut quisquam deserunt inventore praesentium provident libero architecto. Ipsam expedita nesciunt, maiores voluptatibus sed velit fugiat nam et earum blanditiis voluptate voluptates quisquam, autem eos mollitia. Aliquid natus sunt, accusamus autem blanditiis impedit quaerat iure.",
            1.99,
            "package",
            0,
            "https://image.ibb.co/karDmK/thumb20.png",
            images.toString());
    product2.setUser(user1);
    user1.addToProducts(product2);
    productrepo.save(product2);
    Product product3 =
        new Product(
            "Guardian Deities",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore iure provident in pariatur voluptatibus labore perspiciatis reiciendis, eligendi delectus cupiditate at, doloremque earum? Ipsam vitae, soluta a inventore. Quidem, ipsum. Esse expedita a, cupiditate nesciunt dolores! Facilis hic nemo explicabo iure eveniet non dignissimos, velit facere, consequuntur, debitis cum. Aspernatur aut repellat consectetur dolorem nulla asperiores odit vero, necessitatibus possimus, autem, delectus et. Fuga corrupti aliquid ipsa odit nihil inventore eos iusto, ullam dolorem quidem animi accusamus, beatae aspernatur laborum deleniti. Quaerat, nobis, dolorum. Tenetur saepe velit at quae enim accusamus labore qui voluptatum, mollitia nobis cupiditate blanditiis iure eaque repellendus quam facilis temporibus reiciendis deserunt, quibusdam in, ipsa. Sunt officia architecto similique in corrupti voluptatibus fugit consectetur explicabo saepe dignissimos ex adipisci voluptate dicta at eius inventore quasi omnis nulla cum, culpa odio cupiditate. Sapiente quia architecto, suscipit, laboriosam natus reiciendis soluta alias vero praesentium deleniti sit fugiat culpa nemo, consequuntur explicabo nulla velit distinctio cupiditate! Iure, modi quaerat a dignissimos deleniti natus iusto, aut quisquam deserunt inventore praesentium provident libero architecto. Ipsam expedita nesciunt, maiores voluptatibus sed velit fugiat nam et earum blanditiis voluptate voluptates quisquam, autem eos mollitia. Aliquid natus sunt, accusamus autem blanditiis impedit quaerat iure.",
            2.99,
            "package",
            100,
            "https://image.ibb.co/cdUNwK/GUARDIANDEITIESTHUMB.png",
            images.toString());
    product3.setUser(user1);
    user1.addToProducts(product3);
    productrepo.save(product3);
    Product product4 =
        new Product(
            "Ultra Beasts",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore iure provident in pariatur voluptatibus labore perspiciatis reiciendis, eligendi delectus cupiditate at, doloremque earum? Ipsam vitae, soluta a inventore. Quidem, ipsum. Esse expedita a, cupiditate nesciunt dolores! Facilis hic nemo explicabo iure eveniet non dignissimos, velit facere, consequuntur, debitis cum. Aspernatur aut repellat consectetur dolorem nulla asperiores odit vero, necessitatibus possimus, autem, delectus et. Fuga corrupti aliquid ipsa odit nihil inventore eos iusto, ullam dolorem quidem animi accusamus, beatae aspernatur laborum deleniti. Quaerat, nobis, dolorum. Tenetur saepe velit at quae enim accusamus labore qui voluptatum, mollitia nobis cupiditate blanditiis iure eaque repellendus quam facilis temporibus reiciendis deserunt, quibusdam in, ipsa. Sunt officia architecto similique in corrupti voluptatibus fugit consectetur explicabo saepe dignissimos ex adipisci voluptate dicta at eius inventore quasi omnis nulla cum, culpa odio cupiditate. Sapiente quia architecto, suscipit, laboriosam natus reiciendis soluta alias vero praesentium deleniti sit fugiat culpa nemo, consequuntur explicabo nulla velit distinctio cupiditate! Iure, modi quaerat a dignissimos deleniti natus iusto, aut quisquam deserunt inventore praesentium provident libero architecto. Ipsam expedita nesciunt, maiores voluptatibus sed velit fugiat nam et earum blanditiis voluptate voluptates quisquam, autem eos mollitia. Aliquid natus sunt, accusamus autem blanditiis impedit quaerat iure.",
            3.99,
            "package",
            0,
            "https://image.ibb.co/dGM5iz/THUMBNAIL.png",
            images.toString());
    product4.setUser(user1);
    user1.addToProducts(product4);
    productrepo.save(product4);
    Product product5 =
        new Product(
            "Shiny Darkrai",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore iure provident in pariatur voluptatibus labore perspiciatis reiciendis, eligendi delectus cupiditate at, doloremque earum? Ipsam vitae, soluta a inventore. Quidem, ipsum. Esse expedita a, cupiditate nesciunt dolores! Facilis hic nemo explicabo iure eveniet non dignissimos, velit facere, consequuntur, debitis cum. Aspernatur aut repellat consectetur dolorem nulla asperiores odit vero, necessitatibus possimus, autem, delectus et. Fuga corrupti aliquid ipsa odit nihil inventore eos iusto, ullam dolorem quidem animi accusamus, beatae aspernatur laborum deleniti. Quaerat, nobis, dolorum. Tenetur saepe velit at quae enim accusamus labore qui voluptatum, mollitia nobis cupiditate blanditiis iure eaque repellendus quam facilis temporibus reiciendis deserunt, quibusdam in, ipsa. Sunt officia architecto similique in corrupti voluptatibus fugit consectetur explicabo saepe dignissimos ex adipisci voluptate dicta at eius inventore quasi omnis nulla cum, culpa odio cupiditate. Sapiente quia architecto, suscipit, laboriosam natus reiciendis soluta alias vero praesentium deleniti sit fugiat culpa nemo, consequuntur explicabo nulla velit distinctio cupiditate! Iure, modi quaerat a dignissimos deleniti natus iusto, aut quisquam deserunt inventore praesentium provident libero architecto. Ipsam expedita nesciunt, maiores voluptatibus sed velit fugiat nam et earum blanditiis voluptate voluptates quisquam, autem eos mollitia. Aliquid natus sunt, accusamus autem blanditiis impedit quaerat iure.",
            2.99,
            "shiny_legend",
            100,
            "https://image.ibb.co/kVtAiz/darkraithumb.png",
            images.toString());
    product5.setUser(user1);
    user1.addToProducts(product5);
    productrepo.save(product5);
    Product product6 =
        new Product(
            "Shiny Shaymin",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore iure provident in pariatur voluptatibus labore perspiciatis reiciendis, eligendi delectus cupiditate at, doloremque earum? Ipsam vitae, soluta a inventore. Quidem, ipsum. Esse expedita a, cupiditate nesciunt dolores! Facilis hic nemo explicabo iure eveniet non dignissimos, velit facere, consequuntur, debitis cum. Aspernatur aut repellat consectetur dolorem nulla asperiores odit vero, necessitatibus possimus, autem, delectus et. Fuga corrupti aliquid ipsa odit nihil inventore eos iusto, ullam dolorem quidem animi accusamus, beatae aspernatur laborum deleniti. Quaerat, nobis, dolorum. Tenetur saepe velit at quae enim accusamus labore qui voluptatum, mollitia nobis cupiditate blanditiis iure eaque repellendus quam facilis temporibus reiciendis deserunt, quibusdam in, ipsa. Sunt officia architecto similique in corrupti voluptatibus fugit consectetur explicabo saepe dignissimos ex adipisci voluptate dicta at eius inventore quasi omnis nulla cum, culpa odio cupiditate. Sapiente quia architecto, suscipit, laboriosam natus reiciendis soluta alias vero praesentium deleniti sit fugiat culpa nemo, consequuntur explicabo nulla velit distinctio cupiditate! Iure, modi quaerat a dignissimos deleniti natus iusto, aut quisquam deserunt inventore praesentium provident libero architecto. Ipsam expedita nesciunt, maiores voluptatibus sed velit fugiat nam et earum blanditiis voluptate voluptates quisquam, autem eos mollitia. Aliquid natus sunt, accusamus autem blanditiis impedit quaerat iure.",
            1.99,
            "shiny_legend",
            0,
            "https://image.ibb.co/nwAWOz/shayminthumb.png",
            images.toString());
    product6.setUser(user1);
    user1.addToProducts(product6);
    productrepo.save(product6);
    Product product7 =
        new Product(
            "Shiny Japanese Ditto",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore iure provident in pariatur voluptatibus labore perspiciatis reiciendis, eligendi delectus cupiditate at, doloremque earum? Ipsam vitae, soluta a inventore. Quidem, ipsum. Esse expedita a, cupiditate nesciunt dolores! Facilis hic nemo explicabo iure eveniet non dignissimos, velit facere, consequuntur, debitis cum. Aspernatur aut repellat consectetur dolorem nulla asperiores odit vero, necessitatibus possimus, autem, delectus et. Fuga corrupti aliquid ipsa odit nihil inventore eos iusto, ullam dolorem quidem animi accusamus, beatae aspernatur laborum deleniti. Quaerat, nobis, dolorum. Tenetur saepe velit at quae enim accusamus labore qui voluptatum, mollitia nobis cupiditate blanditiis iure eaque repellendus quam facilis temporibus reiciendis deserunt, quibusdam in, ipsa. Sunt officia architecto similique in corrupti voluptatibus fugit consectetur explicabo saepe dignissimos ex adipisci voluptate dicta at eius inventore quasi omnis nulla cum, culpa odio cupiditate. Sapiente quia architecto, suscipit, laboriosam natus reiciendis soluta alias vero praesentium deleniti sit fugiat culpa nemo, consequuntur explicabo nulla velit distinctio cupiditate! Iure, modi quaerat a dignissimos deleniti natus iusto, aut quisquam deserunt inventore praesentium provident libero architecto. Ipsam expedita nesciunt, maiores voluptatibus sed velit fugiat nam et earum blanditiis voluptate voluptates quisquam, autem eos mollitia. Aliquid natus sunt, accusamus autem blanditiis impedit quaerat iure.",
            1.99,
            "shiny_single",
            10,
            "https://image.ibb.co/eTqOmK/dittothumb.png",
            images.toString());
    product7.setUser(user1);
    user1.addToProducts(product7);
    productrepo.save(product7);
    userRepo.save(user1);
    Product product8 =
        new Product(
            "Shiny Genesect",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore iure provident in pariatur voluptatibus labore perspiciatis reiciendis, eligendi delectus cupiditate at, doloremque earum? Ipsam vitae, soluta a inventore. Quidem, ipsum. Esse expedita a, cupiditate nesciunt dolores! Facilis hic nemo explicabo iure eveniet non dignissimos, velit facere, consequuntur, debitis cum. Aspernatur aut repellat consectetur dolorem nulla asperiores odit vero, necessitatibus possimus, autem, delectus et. Fuga corrupti aliquid ipsa odit nihil inventore eos iusto, ullam dolorem quidem animi accusamus, beatae aspernatur laborum deleniti. Quaerat, nobis, dolorum. Tenetur saepe velit at quae enim accusamus labore qui voluptatum, mollitia nobis cupiditate blanditiis iure eaque repellendus quam facilis temporibus reiciendis deserunt, quibusdam in, ipsa. Sunt officia architecto similique in corrupti voluptatibus fugit consectetur explicabo saepe dignissimos ex adipisci voluptate dicta at eius inventore quasi omnis nulla cum, culpa odio cupiditate. Sapiente quia architecto, suscipit, laboriosam natus reiciendis soluta alias vero praesentium deleniti sit fugiat culpa nemo, consequuntur explicabo nulla velit distinctio cupiditate! Iure, modi quaerat a dignissimos deleniti natus iusto, aut quisquam deserunt inventore praesentium provident libero architecto. Ipsam expedita nesciunt, maiores voluptatibus sed velit fugiat nam et earum blanditiis voluptate voluptates quisquam, autem eos mollitia. Aliquid natus sunt, accusamus autem blanditiis impedit quaerat iure.",
            1.99,
            "event",
            7,
            "https://image.ibb.co/nB34Ae/genesect.png",
            images.toString());
    product8.setUser(user1);
    user1.addToProducts(product8);
    productrepo.save(product8);
    Product product9 =
        new Product(
            "Shiny Mew",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore iure provident in pariatur voluptatibus labore perspiciatis reiciendis, eligendi delectus cupiditate at, doloremque earum? Ipsam vitae, soluta a inventore. Quidem, ipsum. Esse expedita a, cupiditate nesciunt dolores! Facilis hic nemo explicabo iure eveniet non dignissimos, velit facere, consequuntur, debitis cum. Aspernatur aut repellat consectetur dolorem nulla asperiores odit vero, necessitatibus possimus, autem, delectus et. Fuga corrupti aliquid ipsa odit nihil inventore eos iusto, ullam dolorem quidem animi accusamus, beatae aspernatur laborum deleniti. Quaerat, nobis, dolorum. Tenetur saepe velit at quae enim accusamus labore qui voluptatum, mollitia nobis cupiditate blanditiis iure eaque repellendus quam facilis temporibus reiciendis deserunt, quibusdam in, ipsa. Sunt officia architecto similique in corrupti voluptatibus fugit consectetur explicabo saepe dignissimos ex adipisci voluptate dicta at eius inventore quasi omnis nulla cum, culpa odio cupiditate. Sapiente quia architecto, suscipit, laboriosam natus reiciendis soluta alias vero praesentium deleniti sit fugiat culpa nemo, consequuntur explicabo nulla velit distinctio cupiditate! Iure, modi quaerat a dignissimos deleniti natus iusto, aut quisquam deserunt inventore praesentium provident libero architecto. Ipsam expedita nesciunt, maiores voluptatibus sed velit fugiat nam et earum blanditiis voluptate voluptates quisquam, autem eos mollitia. Aliquid natus sunt, accusamus autem blanditiis impedit quaerat iure.",
            1.99,
            "shiny_legend",
            100,
            "https://image.ibb.co/heMo3z/mewthumb.png",
            images.toString());
    product9.setUser(user1);
    user1.addToProducts(product9);
    productrepo.save(product9);
    userRepo.save(user1);
  }
}
