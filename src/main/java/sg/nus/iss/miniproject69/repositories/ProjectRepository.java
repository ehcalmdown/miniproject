package sg.nus.iss.miniproject69.repositories;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import sg.nus.iss.miniproject69.models.ItemModel;

@Repository
public class ProjectRepository {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void save(ItemModel items) {// set expiry time temporarily, might make a separate method to save cart if I
                                       // can figure out how to do that
        redisTemplate.opsForValue().set(items.getItemSerialNumber(), items.toJson().toString());
        redisTemplate.expire(items.getItemSerialNumber(), Duration.ofMinutes(60));
    }

    public void save(List<ItemModel> items) {
        Map<String, String> map = new HashMap<>();
        for (ItemModel i : items)
            map.put(i.getItemSerialNumber(), i.toJson().toString());
        redisTemplate.opsForValue().multiSet(map);

        for (String itemSerialNumber : map.keySet())
            redisTemplate.expire(itemSerialNumber, Duration.ofMinutes(60));
    }

    public Optional<ItemModel>get(String itemSerialNumber) { //check for empty value
        if(!redisTemplate.hasKey(itemSerialNumber))
            return Optional.empty();
        String data = redisTemplate.opsForValue().get(itemSerialNumber);
        return Optional.of(ItemModel.create(data));
    }

}
