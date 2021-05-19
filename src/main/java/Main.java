import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.intent.Intent;
import org.javacord.api.entity.message.embed.Embed;
import org.javacord.api.entity.server.Server;


public class Main {
    public static final String token = System.getenv().get("TOKEN");

    public static DiscordApi getApi() {
        return api;
    }

    public static final DiscordApi api = new DiscordApiBuilder()
            .setToken(token)
            .setAllIntentsExcept(Intent.GUILD_PRESENCES)
            .login()
            .join();
    public static void main(String[] args) {
        System.out.println("ready");

        Server tpoj = api.getServerById("713918991059386450").get();
        Server btest = api.getServerById("765515612566716436").get();
        tpoj.addMessageCreateListener(message ->{
            if(message.getChannel().getId() == Long.parseLong(("713918991864823811"))){
                TextChannel reallog = btest.getChannelById("791761476326260776").get().asTextChannel().get();

                for (Embed embed : message.getMessage().getEmbeds()) {
                    reallog.sendMessage(embed.toBuilder());
                };




            }
        });

}}
