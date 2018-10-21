package com.neriudon.sample;

import com.google.common.util.concurrent.FutureCallback;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

public class DiscordBot {
	public static void main(String[] args) {
		new DiscordBot().run();
	}

	public void run() {
		// トークンを指定しSee "How to get the token" below
		DiscordAPI api = Javacord.getApi("", true);
		// Discordに接続
		api.connect(new FutureCallback<DiscordAPI>() {
			// 接続成功時の処理
			public void onSuccess(DiscordAPI api) {
				// メッセージ生成に関するリスナを登録
				api.registerListener(new MessageCreateListener() {
					// メッセージが生成された時に呼ばれる処理
					public void onMessageCreate(DiscordAPI api, Message message) {
						// 生成されたメッセージが"ぬるぽ"の場合
						if ("ぬるぽ".equals(message.getContent())) {
							// "ガッ"を返信
							message.reply("ガッ！");
						}
					}
				});
			}
			// 接続失敗時の処理
			public void onFailure(Throwable t) {
				// ログ出力
				t.printStackTrace();
			}
		});
	}
}