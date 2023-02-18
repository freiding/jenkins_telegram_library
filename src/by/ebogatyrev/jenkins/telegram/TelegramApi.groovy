package by.ebogatyrev.jenkins.telegram

import java.net.URLEncoder;

class TelegramApi {
    def botToken;

    TelegramApi(token) {
        this.botToken = token;
    }

    def sendMessage(String chatId, String message) {
        def _message = URLEncoder.encode(message, "UTF-8")
        def cmd = "curl -s -X POST https://api.telegram.org/bot$botToken/sendMessage -d chat_id=$chatId -d text=$_message"
        cmd.execute()
    }

    def sendFile(String chatId, String filePath) {
        def cmd =  "curl -v -F chat_id=$chatId -F document=@$filePath https://api.telegram.org/bot$botToken/sendDocument"
        cmd.execute()
    }
}
