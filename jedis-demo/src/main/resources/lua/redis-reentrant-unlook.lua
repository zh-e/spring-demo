if (redis.call('exists', KEYS[1]) == 0) then
    return nil;
end ;
if (redis.call('hexists', KEYS[1], ARGV[1]) == 0) then
    return nil;
end ;
local counter = redis.call('hincrby', KEYS[1], ARGV[1], -1);
if (counter > 0) then
    return counter;
else
    redis.call('del', KEYS[1]);
    return nil;
end ;