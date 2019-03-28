using System.Net;

namespace ChronoBibliotheque
{
    public class Chronometre
    {
        int id = 0;

        private const string URL = "http://localhost:8080/api/v1/chronometres/";

        public Chronometre()
        {
            var request = (HttpWebRequest)WebRequest.Create(URL);

            request.Method = "POST";

            using (var response = (HttpWebResponse)request.GetResponse())
            {
                using (var stream = response.GetResponseStream())
                {
                    using (var sr = new System.IO.StreamReader(stream))
                    {
                        id = int.Parse(sr.ReadToEnd());
                    }
                }
            }
        }

        public int getTime()
        {
            var request = (HttpWebRequest)WebRequest.Create(URL+"/"+id);

            request.Method = "GET";
            var content = 0;

            using (var response = (HttpWebResponse)request.GetResponse())
            {
                using (var stream = response.GetResponseStream())
                {
                    using (var sr = new System.IO.StreamReader(stream))
                    {
                        content = int.Parse(sr.ReadToEnd());
                    }
                }
            }

            return content;
        }
    }
}
