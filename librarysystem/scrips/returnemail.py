import smtplib, ssl
import sys

from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText


def send_email(subject, name, title, receiver_email):
    port = 587  # For SSL
    smtp_server = "smtp.gmail.com"
    sender_email = "233889@student.pwr.edu.pl"
    password = "placeholder"

    context = ssl.create_default_context()

    msg = MIMEMultipart("alternative")
    msg['subject'] = subject
    msg['From'] = sender_email
    msg['To'] = receiver_email

    text = f"Hello {name}! Your book: {title} was returned Book details: See you next time! Best regards, Library System Team"
    html = f"""\
    <html>
      <head></head>
      <body>
        <p>Hello {name}!<br><br>
           Your book: {title} was returned<br><br>
           See you next time!<br>
            Library System Team
        </p>
      </body>
    </html>
    """

    part1 = MIMEText(text, 'plain')
    part2 = MIMEText(html, 'html')

    msg.attach(part1)
    msg.attach(part2)

    # Try to log in to server and send email
    server = smtplib.SMTP(smtp_server, port)


    try:

        server.ehlo()  # Can be omitted
        server.starttls(context=context)  # Secure the connection
        server.ehlo()  # Can be omitted
        server.login(sender_email, password)
        server.sendmail(sender_email, receiver_email, msg.as_string())
        print("sended")
        # TODO: Send email here
    except Exception as e:
        # Print any error messages to stdout
        print(e)
    finally:
        server.quit()

if __name__ == "__main__":
    email = sys.argv[1]
    name = sys.argv[2]
    subject = sys.argv[3]
    title = ' '.join(sys.argv[4:])

    send_email(subject,name, title, email)