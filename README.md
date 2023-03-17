# Border Waiting Area Notifier

## Reasons and tasks
Creating this application I'm planning to solve first of all my private need.

While being in border waiting area you have to know status of the queue and your order in it. For this reason you have to watch on panel or refresh website https://mon.declarant.by/zone . On a panel you can see only those car plates that can go to customs barrier but actual status is available only online.

To know your actual order you have to refresh webpage everytime. So we have several problems with this
1. To get actual info you need to manually refresh page
2. By default website displays lorries info. To get car info you have to switch to cars in settings and then list to your info or filter by typing plate number. This mean you need to do additional manipulations everytime you do a refresh
3. There are places with bad internet coverage.

As a result of this three points we have a every minute need to do page update.

Application task is to collect actual data and inform users in case of order and status change. Expect to inform through telegram bot.
