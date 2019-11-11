## Do You Know a Racist?

As reported by [ars Technica](https://arstechnica.com/information-technology/2019/11/massive-data-dump-exposes-members-of-website-for-violent-white-supremacists/), the violent white supremacist group Iron March had a massive breach which yielded a dump of all their data.

This includes member data, posts and chats between them.

This project uses a small subset of that data, namely the email addresses.

You can enter an email address into the form at: [https://doyouknowaracist.dev](https://doyouknowaracist.dev) and the site will show you if that email address is a member of this hate group.

There's only two possible outcomes:

1. PROBABLY (email address found in the data dump)
2. UNKNOWN (email not found in the data dump)

There's also an RESTful API to get a json response:

ex:
```
curl https://doyouknowaracist.dev/api/v1/is_racist/notreal@example.com
```
